import React, {useState} from "react"
//MUI
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import ListItemButton from "@mui/material/ListItemButton";
import RemoveIcon from '@mui/icons-material/Remove';
import IconButton from "@mui/material/IconButton";
//CUSTOM COMPONENTS
import NavBar from "./favorites-navbar";
//STYLES
import "../../stylesheets/layout/page.scss"
import { Tooltip } from "@mui/material";


const FactoritesScreen = () => {
    const [items,setItems] = useState([
            {name:'Pinky',avatar:'example',id:1},
            {name:'Army Green',avatar:'example',id:2},
            {name:'Montaray',avatar:'example',id:3},
            {name:'Mosago',avatar:'example',id:4},
            {name:'Triage',avatar:'example',id:5},
            {name:'Klimindor',avatar:'example',id:6}]);

    const clickHandler = id => {
        const _items = [...items];
        const index = items.findIndex(item => item.id === id);
        //Set selected item
        _items.splice(index, 1);
        setItems(_items.sort((a,b) =>  a.name.localeCompare(b.name)));
    }

    return ( 
        <div className="page">
            <NavBar/>
            <List className="content">
                { items.map((entry) => 
                <ListItemButton key={entry.id} className="entry-wrapper">
                        <ListItem className="entry-item" >
                            <ListItemAvatar className="profile-icon">
                                <Avatar src=""/>
                            </ListItemAvatar>
                            <h6>{entry.name}</h6>
                            <div className="entry-action-container">
                                <Tooltip title="remove from favorites">
                                    <IconButton onClick={() => clickHandler(entry.id)}>
                                        <RemoveIcon className="icon"/> 
                                    </IconButton>
                                </Tooltip>
                            </div>
                        </ListItem>
                </ListItemButton>
                )}           
            </List> 
        </div>
    );
}

export default FactoritesScreen;