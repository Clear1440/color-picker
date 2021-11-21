//react
import React from 'react';
import NavBar from './setting-navbar';
import Select from '@mui/material/Select'
import FormControl from '@mui/material/FormControl'
import { useState } from 'react';
//styles
import "./settingsStyles.scss";
import "../../stylesheets/layout/page.scss"
import { InputLabel } from '@mui/material';



const SettingsScreen = () => {
    const appStyles = [
        {primaryColor: 'brown', secondaryColor: 'tan', name: 'woody', id: 1},
        {primaryColor: 'violet', secondaryColor: 'yellow', name: 'neon', id: 2},
    ]

    const [editSettings, setEditSettings] = useState({
        appTheme: 1
    });

    return(
        <div className="page">
            <NavBar />
            <FormControl className='form'>
                <InputLabel htmlFor="appTheme" shrink={true}>App Theme</InputLabel>
                <Select
                    id="demo-simple-select"
                    value={editSettings.appTheme}
                    native
                    label="App Theme"
                    name="App Theme"
                    onChange={(e) => 
                        setEditSettings({
                            ...editSettings,
                            appTheme: e.currentTarget.value
                        })
                    }
                >
                    {appStyles.map((option => <option value={option.id} key={option.id}>{option.name}</option>))}
                </Select>
            </FormControl>
        </div>
    )
}

export default SettingsScreen;