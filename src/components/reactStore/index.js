import { createStore} from 'redux';

const store = createStore(() => {
    return {
        exampleSetOfThemes: []
    }
});

export default store;