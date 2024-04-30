import React from "react";
import Header from "./Header";
import { Link } from "react-router-dom";
function Register() {
    return(
        <>
            <Header/>
            <div className="container ">
                <div className="loginPage">
                    <div className="loginForm">

                        <div className="headerForm text-center">
                            <h2>Inscription</h2>
                        </div>
                        <hr className="border-3"/>
                        <div className="inputGroup mb-3">
                            <label htmlFor="email" className="mb-2">Entrez votre adresse email :</label>
                            <input type="mail" name="email"/>
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="fullName" className="mb-2">Entrez votre prenom et nom :</label>
                            <input type="text" name="fullName"/>
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="password" className="mb-2">Entrez votre mot de passe :</label>
                            <input type="password" name="password"/>
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="password" className="mb-2">Vérifiez votre mot de passe :</label>
                            <input type="password" name="password"/>
                        </div>
                        <hr className="border-3"/>
                        <div className="submitBtn">
                            <input type="submit" value="Register" />
                        </div>
                        <Link to={"/login"} className="redirect">
                            <p >Déjà un compte ?</p>
                        </Link>
                    </div>
                </div>
            </div>
        </>
        
    )
    
}



export default Register