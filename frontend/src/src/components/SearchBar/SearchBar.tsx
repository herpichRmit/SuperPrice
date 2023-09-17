import './SearchBar.css';

import Nav from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';

import { useState, useEffect } from "react"


export default function SearchBar() {

  return (
     <form target="#">
        <div className="search-bar">
            <input className="form-control search-bar" type="text" placeholder="Search results for products: product 1. product 2" />
        </div>
     </form>



  )
}

