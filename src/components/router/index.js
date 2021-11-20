import HomeScreen from "../../container/homescreen";
import SettingsScreen from "../../container/settingscreen";

import {
    BrowserRouter,
    Routes,
    Route
  } from "react-router-dom";


const Routing = () => {
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<HomeScreen />} />
                <Route path="settings" element={<SettingsScreen />} />
            </Routes>
        </BrowserRouter>
    );
}

export default Routing;