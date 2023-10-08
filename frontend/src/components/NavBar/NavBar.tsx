import './NavBar.css';
import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import Link from 'next/link';
import Button from '@mui/material/Button';
import Image from 'next/image'
import logo from '../../../public/logo.png'


import SearchBar from '../SearchBar/SearchBar';

export default function NavBar({shouldShowSearchBar = true}) {
  return (
    <nav className="nav-bar" >
        <Link href="/">
        <Image className="logo" src={logo} alt={''} />
        </Link>
        {shouldShowSearchBar ? <SearchBar /> : ""}
        <ul className="nav-links">
            <li><Link href="/signup" className="nav-link"><p>Sign Up</p></Link></li>
            <li><Link href="/login" className="nav-link"><p>Log In</p></Link></li>
        </ul>
    </nav>
  )
}

