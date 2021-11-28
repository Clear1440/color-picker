import React, {useState} from "react"
//MUI
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import ListItemButton from "@mui/material/ListItemButton";
// import Button from "@mui/material/Button";
//CUSTOM COMPONENTS
import NavBar from "./home-navbar";
//STYLES
import "../../stylesheets/layout/page.scss"
import {useNavigate} from "react-router-dom";
import {changeColor} from "../../scripts/colorChanger";

const HomeScreen = () => {
    let navigate = useNavigate();
    const [items,setItems] = useState([
            {name:'Pinky',avatar:'example',id:1, style: [{id: "page", style: "background-color: green"}]},
            {name:'Army Green',avatar:'example',id:2, style: [{id: "page", style: "background-color: red"}]},
            {name:'Montaray',avatar:'example',id:3, style: [{id: "page", style: "background-color: yellow"}]},
            {name:'Mosago',avatar:'example',id:4, style: [{id: "page", style: "background-color: cyan"}]},
            {name:'Triage',avatar:'example',id:5, style: [{id: "page", style: "background-color: tan"}]},
            {name:'Klimindor',avatar:'example',id:6, style: [{id: "page", style: "background-color: brown"}]}]);

    const [selectedItem, setSelectedItem] = useState({name:'default',avatar:'example',id:7, style: [{id: "page", style: "background-color: #192734"}]});

    const clickHandler = async id => {
        const _selectedItem = selectedItem;
        const _items = [...items];
        const index = items.findIndex(item => item.id === id);
        //Set selected item
        setSelectedItem(items[index]);
        _items.splice(index, 1);
        _items.push(_selectedItem);
        setItems(_items.sort((a,b) =>  a.name.localeCompare(b.name)));
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