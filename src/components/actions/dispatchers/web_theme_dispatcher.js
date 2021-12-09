import fetchHelper from "../../fetchHelper";

class web_theme_dispatcher {
    fetchWebTheme = async(id) => {
        return await fetchHelper.GET({path: `/rest/v1/web_theme/${id}`})
    }
}

export default new web_theme_dispatcher();