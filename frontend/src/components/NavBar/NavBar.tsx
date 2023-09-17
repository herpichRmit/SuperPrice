import './NavBar.css';
import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import Link from 'next/link';
import Button from '@mui/material/Button';

import SearchBar from '../SearchBar/SearchBar';

export default function NavBar({shouldShowSearchBar = true}) {
  return (
    <nav className="nav-bar" >
        <img className="logo" src="/logo.png" />
        {shouldShowSearchBar ? <SearchBar /> : ""}
        <div className="flex justify-end">
          <div> 
            <Link href="/login">
              <p>Login</p>
            </Link>
          </div>
          <div>
            <Link href="/signup">
              <p>Sign Up</p>
            </Link>
          </div>
        </div>
    </nav>
  )
}

