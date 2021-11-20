import React, {useState} from "react"
//MUI
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import Card from '@mui/material/Card';
import ListItemButton from "@mui/material/ListItemButton";
import Button from "@mui/material/Button";
//CUSTOM COMPONENTS
import { NavBar } from "../../components/navbar";
//STYLES
import "../../stylesheets/layout/page.scss"

const HomeScreen = () => {
    const [items,setItems] = useState([
            {name:'Pinky',avatar:'example',id:1},
            {name:'Army Green',avatar:'example',id:2},
            {name:'Army Green',avatar:'example',id:3},
            {name:'Army Green',avatar:'example',id:4},
            {name:'Army Green',avatar:'example',id:5},
            {name:'Klimindor',avatar:'example',id:6}]);

    const [selectedItem, setSelectedItem] = useState({name:'Blues',avatar:'example',id:7,selected:false});

    const clickHandler = id => {
        const _selectedItem = selectedItem;
        const _items = [...items];
        const index = items.findIndex(item => item.id == id);
        //Set selected item
        setSelectedItem(items[index]);
        _items.splice(index, 1);
        _items.push(_selectedItem);
        setItems(_items);
    }

    return ( 
        <div className="page">
            <NavBar/>
            <ListItemButton disabled onClick={clickHandler} className="entry-wrapper">
                    <ListItem className="entry-item selected">
                                <ListItemAvatar className="profile-icon">
                            <Avatar src=""/>
                        </ListItemAvatar>
                        <h6>{selectedItem.name}</h6>
                    </ListItem>
            </ListItemButton>
            <h5>Available Profiles for This Site</h5>
                <List className="content">
                    { items?.map((entry) => 
                    <ListItemButton onClick={() => clickHandler(entry.id)} className="entry-wrapper">
                            <ListItem className="entry-item">
                                <ListItemAvatar className="profile-icon">
                                    <Avatar src=""/>
                                </ListItemAvatar>
                                <h6>{entry.name}</h6>
                            </ListItem>
                    </ListItemButton>
                    )}           
                </List> 
            <Button className="market-button" variant="contained">MarketPlace</Button> 
        </div>
    );
}

export default HomeScreen;