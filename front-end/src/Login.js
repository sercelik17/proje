import React, {useState} from "react";
import { NavLink} from 'react-router-dom';




function Login() {
    const [username, setUsername] = useState([]);
    const [password, setPassword] = useState();
    return(
        <form>
            <div className='main'>
                <div className='sub-main'>
                    <div>
                        <div>
                            <h1 className='LHeader'>LOGIN</h1>
                            <div>
                                <input type="text" placeholder='Enter Username' className='fill' onChange={event=>{setUsername(event.target.value)} }/>
                            </div>
                            <div className='second-input'>
                                <input type="password" placeholder='Enter Password' className='fill' onChange={event=>{setPassword(event.target.value)} }/>
                            </div>
                            <div className='login-btn'>
                                <button className="login" >
                                    login
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    );
}
export default Login;