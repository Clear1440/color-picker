import React, {useState} from "react"
//MUI
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import ListItemButton from "@mui/material/ListItemButton";
//CUSTOM COMPONENTS
import NavBar from "./home-navbar";
//STYLES
import "../../stylesheets/layout/page.scss"
import {useNavigate} from "react-router-dom";
import {changeColor, unsetChangeColor} from "../../scripts/content";

const HomeScreen = () => {
    let navigate = useNavigate();
    const [items,setItems] = useState([
            {name:'tan header',avatar:'example',id:1, style: [
                    {id: "site-nav", style: "background-color: tan;"},
                    {id: "site-nav-desktop-item", style: "background-color: black"},
                    {id: "filter-subnav", style: "background-color: darkgrey"},
                    {id: "wrap-inner", style: "background-color: darkgrey"}
                ]},
            {name:'grey background',avatar:'example',id:2, style: [
                {id: "site-nav-desktop-item", style: "background-color: black"},
                    {id: "filter-subnav", style: "background-color: darkgrey"},
                    {id: "wrap-inner", style: "background-color: darkgrey"}]},
            {name:'pink',avatar:'example',id:3, style: [
                    {id: "site-nav", style: "background-color: pink;"},
                    {id: "site-nav-desktop-item", style: "background-color: pink"},
                    {id: "filter-subnav", style: "background-color: pink"},
                    {id: "wrap-inner", style: "background-color: pink"}]
            },
    ]);

    const [selectedItem, setSelectedItem] = useState({name:'default',avatar:'example',id:7, style: [{id: "page", style: "none"}]});

    const clickHandler = async id => {
        const _selectedItem = selectedItem;
        const _items = [...items];
        const index = items.findIndex(item => item.id === id);
        //remove color styling
        await unsetChangeColor(_selectedItem.style);
        //Set selected item
        setSelectedItem(items[index]);
        _items.splice(index, 1);
        _items.push(_selectedItem);
        setItems(_items.sort((a,b) =>  a.name.localeCompare(b.name)));
        //apply new color styling
        await changeColor(items[index].style);
    }

    const clickHandlerSelected = id => {
        navigate('/web-theme');
    }

    return ( 
        <div className="page" id="page">
            <NavBar/>
            <ListItemButton onClick={() => clickHandlerSelected(selectedItem.id)} className="entry-wrapper">
                    <ListItem className="entry-item selected">
                                <ListItemAvatar>
                            <Avatar src=""/>
                        </ListItemAvatar>
                        <h6>{selectedItem.name}</h6>
                    </ListItem>
            </ListItemButton>
            <h5>Available Profiles for This Site</h5>
                <List className="content">
                    { items?.map((entry) => 
                    <ListItemButton key={entry.id} onClick={() => clickHandler(entry.id)} className="entry-wrapper">
                            <ListItem className="entry-item" >
                                <ListItemAvatar>
                                    <Avatar src=""/>
                                </ListItemAvatar>
                                <h6>{entry.name}</h6>
                            </ListItem>
                    </ListItemButton>
                    )}           
                </List> 
            {/* <Button className="market-button" variant="contained">MarketPlace</Button>  */}
        </div>
    );
}

export default HomeScreen;