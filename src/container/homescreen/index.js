/*global chrome*/
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
import {useSelector} from "react-redux";

const HomeScreen = () => {
    let navigate = useNavigate();
    const exampleSet = useSelector(state => state.exampleSetOfThemes);
    const [selectedItem, setSelectedItem] = useState(exampleSet[3]);
    const [items,setItems] = useState(exampleSet.filter(a => {
        return a.id !== selectedItem.id
    }));

    const addCustomStyling = (customCSS) => {
        const styleFunc = (css) => {
            //remove old styling changes
            document.getElementById("custom-styling-picker")?.remove();
            //add new stylings
            const styleScript = document.createElement('style');
            styleScript.id = "custom-styling-picker";
            styleScript.innerHTML = css;
            document.head.appendChild(styleScript);
        }
        //put ^ in the webpage
        chrome.tabs.executeScript({
            code: `(${styleFunc})('${customCSS.replace(/\n/g, ' ')}');`
        }, (e) => {
            console.log('Popup script error:', e)
        });
    }


    const clickHandler = id => {
        const _selectedItem = selectedItem;
        const _items = [...items];
        const index = items.findIndex(item => item.id === id);
        //Set selected item
        setSelectedItem(items[index]);
        _items.splice(index, 1);
        _items.push(_selectedItem);
        setItems(_items.sort((a,b) =>  a.name.localeCompare(b.name)));
        addCustomStyling(items[index].style);
    }

    const clickHandlerSelected = () => {
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