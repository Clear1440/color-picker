import HomeScreen from "../../container/homescreen";
import SettingsScreen from "../../container/settingscreen";
import FavoritesScreen from "../../container/favoritesscreen";

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
                <Route path="favorites" element={<FavoritesScreen />} />
            </Routes>
        </MemoryRouter>
    );
}

export default Routing;