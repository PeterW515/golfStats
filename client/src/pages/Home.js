import React from 'react';
import '../App.css';
import AppNavbar from '../components/AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

const Home = () => {
    return (
        <div>
            <AppNavbar />
            <Container fluid>
                <Button color="link"><Link to="/viewAllScores">View All Scores</Link></Button>
            </Container>
        </div>
    );
}

export default Home;