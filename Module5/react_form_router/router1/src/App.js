import './App.css';
import {Routes, Route, Link} from 'react-router-dom'
import {Home} from './component/Home'
import {Login} from './component/Login'

function App() {
    return (
        <>
            <Routes>
                <Route path="/home" element={<Home/>}/>
                <Route path="/login" element={<Login/>}/>
            </Routes>
        </>
    );
}

export default App;
