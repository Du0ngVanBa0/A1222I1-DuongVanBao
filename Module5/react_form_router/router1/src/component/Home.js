import {useLocation} from 'react-router-dom'

export function Home() {
    const location = useLocation();
    const data = location.state;

    return(
        <h1>hello {data.username} have password {data.password}</h1>
    )
}