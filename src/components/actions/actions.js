import user_dispatcher from "./dispatchers/user_dispatcher"
import web_theme_dispatcher from "./dispatchers/web_theme_dispatcher";

class Actions{

    fetchUserList(){
        return user_dispatcher.fetchUserList();
    }

    fetchWebTheme(id){
        return web_theme_dispatcher.fetchWebTheme(id);
    }

}

export default new Actions();