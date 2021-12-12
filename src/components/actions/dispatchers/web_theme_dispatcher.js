import fetchHelper from "../../fetchHelper";

class web_theme_dispatcher {
    fetchWebTheme = async(id) => {
        return await fetchHelper.GET({path: `/rest/v1/web_theme/${id}`})
    }

    createWebTheme = async(webTheme) => {
        return await fetchHelper.POST({
            path: `/rest/v1/web_themes/`, 
            data : webTheme
        })
    }

    updateWebTheme = async({id, webTheme}) => {
        return await fetchHelper.PATCH({
            path: `/rest/v1/web_themes/${id}`, 
            data: webTheme
        })
    }

    deleteWebTheme = async(id) => {
        return await fetchHelper.DELETE({path: `/rest/v1/web_themes/${id}`})
    }
}

export default new web_theme_dispatcher();