const BASE_URL = "http://localhost:8081";


class fetchHelper{

    GET = ({path, options}) => {
        return fetch(BASE_URL + path, 
        {
            method: 'GET',
            mode: 'cors',
            ...options
        });
    }

    POST = ({path, data, options}) => {
        return fetch(BASE_URL + path, 
        {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            },
            ...options
        });
    }

    PATCH = ({path, data, options}) => {
        return fetch(BASE_URL + path, 
        {
            method: 'PATCH',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            },
            ...options
        });
    }

    PUT = ({path, data, options}) => {
        return fetch(BASE_URL + path, 
        {
            method: 'PUT',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            },
            ...options
        });
    }

    DELETE = ({path, options}) => {
        return fetch(BASE_URL + path, 
        {
            method: 'DELETE',
            ...options
        });
    }
}

export default new fetchHelper();