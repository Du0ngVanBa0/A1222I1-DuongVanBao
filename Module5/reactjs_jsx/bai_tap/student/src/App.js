import logo from './logo.svg';
import './App.css';
import React from "react";


function App() {
    const students1 = [
        {
            company: 'Alfreds Futterkiste',
            contact: 'Maria Anders',
            country: 'Germany'
        },
        {
            company: 'Centro comercial Moctezuma',
            contact: 'Francisco Chang',
            country: 'Mexico'
        },
        {
            company: 'Ernst Handel',
            contact: 'Roland Mendel',
            country: 'Austria'
        },
        {
            company: 'Island Trading',
            contact: 'Helen Bennett',
            country: 'UK'
        },
        {
            company: 'Laughing Bacchus Winecellars',
            contact: 'Yoshi Tannamuri',
            country: 'Canada'
        },
        {
            company: 'Magazzini Alimentari Riuniti',
            contact: 'Giovanni Rovelli',
            country: 'Italy'
        }
    ]

    console.log(students1)

    return (
        <div className="App">
            <table>
                <thead>Students</thead>
                <tbody>
                {
                    students1.map(s => (
                        <tr key={s.contact}>
                            <td>{s.company}</td>
                            <td>{s.contact}</td>
                            <td>{s.country}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    );
}

export default App;
