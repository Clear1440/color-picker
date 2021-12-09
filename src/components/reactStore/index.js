import { createStore} from 'redux';

const store = createStore(() => {
    return {
        exampleSetOfThemes: [
            {
                name:'tan header',
                avatar:'example',
                id:1, 
                style: `.site-nav { 
                    background-color: tan
                }`
            },{
                name:'grey header',
                avatar:'example',
                id:2,
                style: 
                    `.site-nav {
                        background-color: grey
                    }`
            },{
                name:'pink header',
                avatar:'example',
                id:3, 
                style: 
                    `.site-nav {
                        background-color: pink
                    }`
            },
            {
                name:'default',
                avatar:'example',
                id:4, 
                style: ""
            },
        ]
    }
});

export default store;