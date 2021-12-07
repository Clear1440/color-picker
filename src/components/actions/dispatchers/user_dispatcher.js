import fetchHelper from "../../fetchHelper";

class user_dispatcher {
    fetchUserList = async() => {
        return await fetchHelper.GET({path: "/rest/v1/users/"})
    }
}

export default new user_dispatcher();