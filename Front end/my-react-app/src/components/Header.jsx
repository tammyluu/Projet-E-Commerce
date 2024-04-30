import React, { useState } from "react";
import { NavLink } from "react-router-dom";


function Header() {
    const [burger, setBurger] = useState(false)

    return( 
    <>
        <header>
            <div className="leftArea" >
                <img src="src/images/lignes-doptions.png" onClick={() => setBurger(!burger)} alt="categories" height={50} />
                {
                burger && <div className="dropdown">
                    Nos produits
                </div>
            } </div>
            
            <div className="rightArea">
                <div className="login">
                    <NavLink 
                    to={"/login" }
                    className={({isActive})=>isActive }
                    >
                        <img src="src/images/utilisateur.png" alt="photo d'utilisateur" height={50} />
                        <p>Me connecter</p>
                    </NavLink>
                </div>
                <div className="cart">
                    <NavLink>
                        <img src="src/images/chariot-de-chariot.png" alt="panier" height={50}/>
                        <p>Mon panier</p>
                    </NavLink>
                </div>
                
            </div>
        </header>
    </>  
     )
   
    
}
export default Header;