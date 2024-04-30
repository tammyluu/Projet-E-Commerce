import React from "react";
import Header from "./Header";
import { Link } from "react-router-dom";

function Login() {
    return(
        <>
            <Header/>
            <div className="container ">
                <div className="loginPage">
                    <div className="loginForm">

                        <div className="headerForm text-center">
                            <h2>Connexion</h2>
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="email" className="mb-2">Entrez votre adresse email :</label>
                            <input type="mail" name="email"/>
                        </div>

                        <div className="inputGroup">
                            <label htmlFor="password" className="">Entrez votre mot de passe :</label>
                            <input type="password" name="password"/>
                        </div>
                        <br />
                        <hr className="border-3"/>
                        <div className="submitBtn">
                            <input type="submit" value="Login" />
                        </div>
                        
                        <Link to={"/register"} className="redirect">
                        <p >Pas encore inscrit ?</p>
                        </Link>
                    </div>
                </div>
            </div>
        </>
        
    )
    
}



export default Login