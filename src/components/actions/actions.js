import user_dispatcher from "./dispatchers/user_dispatcher"

class Actions{

    fetchUserList(){
        return user_dispatcher.fetchUserList();
    }

}

export default new Actions();