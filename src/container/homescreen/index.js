import React from "react"
import { NavBar } from "../../components/navbar";
import "../../stylesheets/layout/page.scss"

const HomeScreen = () => {
    return ( 
        <div className="page">
            <NavBar/>
            <h6> Hellow Box </h6>  
        </div >
    );
}

export default HomeScreen;