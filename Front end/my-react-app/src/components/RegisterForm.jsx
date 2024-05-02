import React, { useState } from "react";
import Header from "./Header";
import { Link } from "react-router-dom";
import axios from "axios";

function Register() {
    const [email,setEmailInput] = useState("")
    const [fullName,setFullNameInput] = useState("")
    const [password,setPasswordInput] = useState("")
    const [address,setAddressInput] = useState("")

    const handleSubmit = async(e)=>{
        e.preventDefault()
        const consumer = {
            fullName , email, password , address
        }
        await axios.post("http://localhost:8090/api/consumer" , consumer)
    }


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
                        <form onSubmit={handleSubmit}>
                        <div className="inputGroup mb-3">
                            <label htmlFor="email" className="mb-2">Entrez votre adresse email :</label>
                            <input type="mail" name="email" onChange={(e)=>{setEmailInput(e.target.value)}} value={email} />
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="fullName" className="mb-2">Entrez votre prenom et nom :</label>
                            <input type="text" name="fullName" onChange={(e)=>{setFullNameInput(e.target.value)}} value={fullName}/>
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="password" className="mb-2">Entrez votre mot de passe :</label>
                            <input type="password" name="password" onChange={(e)=>{setPasswordInput(e.target.value)}} value={password}/>
                        </div>
                        <div className="inputGroup mb-3">
                            <label htmlFor="address" className="mb-2">Entrez votre addresse</label>
                            <input type="text" name="address" onChange={(e)=>{setAddressInput(e.target.value)}} value={address}/>
                        </div>
                        <hr className="border-3"/>
                        <div className="submitBtn">
                            <input type="submit" value="Register" />
                        </div></form>
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