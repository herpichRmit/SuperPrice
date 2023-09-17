'use client'

import './SearchBar.css';
import Link from 'next/link';

import Form from 'react-bootstrap/Form';
import React, { useState, useEffect } from 'react';

export default function SearchBar() {
   const [searchText, setSearchText] = useState<String>('');

   const inputHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
      setSearchText(e.target.value);
    };

  return (
     <form target="#">
        <div className="search-bar">
            <input className="form-control search-bar" type="text" placeholder="Search groceries and save money" onChange={inputHandler}  />
            <Link href={'/search/'+ searchText} className="search_button">Search</Link>
        </div>
     </form>
  )
}