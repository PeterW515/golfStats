import React from 'react';
import './App.css';
import Home from './pages/Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import PlayedHoleList from './pages/PlayedHoleList';


const App = () => {
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Home />} />
                <Route path='/playedHoles' exact={true} element={<PlayedHoleList />} />
            </Routes>
        </Router>
    )
}

export default App;