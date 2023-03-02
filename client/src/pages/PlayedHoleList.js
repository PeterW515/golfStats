import React, { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../components/AppNavbar';
import { Link } from 'react-router-dom';
import { getPlayedHoles } from '../utils/queries';

const PlayedHoleList = () => {

    const [playedHoles, setPlayedHoles] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('api/playedHoles')
            .then(response => response.json())
            .then(data => {
                setPlayedHoles(data);
                setLoading(false);
            })
    }, []);


    const remove = async (id) => {
        await fetch(`/api/playedHoles/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedPlayedHoles = [...playedHoles].filter(i => i.id !== id);
            setPlayedHoles(updatedPlayedHoles);
        });
    }

    if (loading) {
        return <p>Loading...</p>;
    }

    const playedHoleList = playedHoles.map(playedHole => {
        return <tr key={playedHole.id}>
            <td style={{ whiteSpace: 'nowrap' }}>{playedHole.courseName}</td>
            <td>{playedHole.datePlayed}</td>
            <td>{playedHole.tees}</td>
            <td>{playedHole.holeNumber}</td>
            <td>{playedHole.par}</td>
            <td>{JSON.stringify(playedHole.fairwayInRegulation)}</td>
            <td>{playedHole.teeShotDirection}</td>
            <td>{JSON.stringify(playedHole.greenInRegulation)}</td>
            <td>{JSON.stringify(playedHole.upAndDown)}</td>
            <td>{playedHole.putts}</td>
            <td>{playedHole.score}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="primary" tag={Link} to={"/playedHole/" + playedHole.id}>Edit</Button>
                    <Button size="sm" color="danger" onClick={() => remove(playedHole.id)}>Delete</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar />
            <Container fluid>
                <div className="float-end">
                    <Button color="success" tag={Link} to="/playedHole/new">Add Hole</Button>
                </div>
                <h3>My Played Holes</h3>
                <Table className="mt-4">
                    <thead>
                        <tr>
                            <th>Course Name</th>
                            <th>Date Played</th>
                            <th>Tees</th>
                            <th>Hole</th>
                            <th>Par</th>
                            <th>FIR</th>
                            <th>Tee Shot Direction</th>
                            <th>GIR</th>
                            <th>Up/Down</th>
                            <th>Putts</th>
                            <th>Score</th>
                        </tr>
                    </thead>
                    <tbody>
                        {playedHoleList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
};

export default PlayedHoleList;