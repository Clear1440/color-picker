import './App.css';
import Routing from './components/router';
import ReactStore from './components/reactStore';
import { Provider } from 'react-redux';

function App() {
    return ( 
    <div className = "App" >
        <header className = "App-header" >
            <Provider store={ReactStore}>
                <Routing/>
            </Provider>
        </header>  
    </div>
    );
}

export default App;