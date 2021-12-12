//react
import React, {useState} from 'react';
import NavBar from './web-theme-navbar';
//styles
import "./webThemeStyles.scss";
import "../../stylesheets/layout/page.scss"
import {Avatar, Button, FormControl, IconButton, TextField} from "@mui/material";
import CreateIcon from '@mui/icons-material/Create';
import actions from '../../components/actions/actions';
import {useNavigate} from "react-router-dom";


const WebThemeConfigScreen = () => {
    let navigate = useNavigate();

    const [themeInfo, setThemeInfo] = useState({
        name: "",
        associatedUrl: "",
        theme: ""
    });


    const onSave = () => {
        actions.createWebTheme(themeInfo);
        navigate("/");
    }

    return(
        <div className="page">
            <NavBar />
            <div className="theme-content">
                <div className="head-container">
                    <div className="profile-icon">
                        <Avatar className="avatar-icon"/>
                        <div className="edit-icon-container">
                            <IconButton className="icon-button">
                                <CreateIcon/>
                                edit icon
                            </IconButton>
                        </div>
                    </div>

                </div>
                <FormControl variant="outlined" style={{width: '90%'}} >
                    <TextField
                        className="input-field"
                        value={themeInfo.name}
                        label="Theme Name"
                        name="Theme Name"
                        onChange={(e) =>
                            setThemeInfo({
                                ...themeInfo,
                                name: e.currentTarget.value
                            })
                        }
                    >
                    </TextField>

                    <TextField
                        className="input-field"
                        value={themeInfo.associatedUrl}
                        label="Associated Url"
                        name="Associated Url"
                        onChange={(e) =>
                            setThemeInfo({
                                ...themeInfo,
                                associatedUrl: e.currentTarget.value
                            })
                        }
                    >
                    </TextField>

                    <TextField
                        className="input-field multiline"
                        value={themeInfo.theme}
                        label="Custom CSS"
                        name="Custom CSS"
                        multiline={true}
                        minRows={3}
                        maxRows={10}
                        onChange={(e) =>
                            setThemeInfo({
                                ...themeInfo,
                                theme: e.currentTarget.value
                            })
                        }
                    >
                    </TextField>
                    <Button variant="contained" className="tan-button" onClick={() => onSave()}>
                        Save
                    </Button>
                </FormControl>
            </div>

        </div>
    )
}

export default WebThemeConfigScreen;