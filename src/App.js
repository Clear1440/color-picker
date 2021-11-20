import logo from './logo.svg';
import './App.css';
import "./screens/homeScreen";
import homeScreen from './screens/homeScreen';

function App() {
    return ( 
    <div className = "App" >
        <header className = "App-header" >
            <homeScreen />
        </header>  
    </div>
    );
}

export default App;