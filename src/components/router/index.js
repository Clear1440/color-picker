import HomeScreen from "../../container/homescreen";
import SettingsScreen from "../../container/settingscreen";

import {
    MemoryRouter,
    Routes,
    Route
  } from "react-router-dom";


const Routing = () => {
    return(
        <MemoryRouter>
            <Routes>
                <Route path="/" element={<HomeScreen />} />
                <Route path="settings" element={<SettingsScreen />} />
            </Routes>
        </MemoryRouter>
    );
}

export default Routing;