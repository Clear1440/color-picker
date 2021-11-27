//react
import React, {useState} from 'react';
import NavBar from './web-theme-navbar';
//styles
import "./webThemeStyles.scss";
import "../../stylesheets/layout/page.scss"
import {Avatar, FormControl, IconButton, TextField} from "@mui/material";
import CreateIcon from '@mui/icons-material/Create';

const WebThemeConfigScreen = () => {
    const [themeInfo, setThemeInfo] = useState({
        name: "theme one name",
        url: "http://localhost/**",
        css: ""
    });

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
                        value={themeInfo.url}
                        label="Associated Url"
                        name="Associated Url"
                        onChange={(e) =>
                            setThemeInfo({
                                ...themeInfo,
                                url: e.currentTarget.value
                            })
                        }
                    >
                    </TextField>

                    <TextField
                        className="input-field multiline"
                        value={themeInfo.css}
                        label="Custom CSS"
                        name="Custom CSS"
                        multiline={true}
                        minRows={3}
                        maxRows={10}
                        onChange={(e) =>
                            setThemeInfo({
                                ...themeInfo,
                                css: e.currentTarget.value
                            })
                        }
                    >
                    </TextField>

                </FormControl>
            </div>

        </div>
    )
}

export default WebThemeConfigScreen;