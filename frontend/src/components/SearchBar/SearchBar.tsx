'use client'
import './SearchBar.css';
import Link from 'next/link';

import Form from 'react-bootstrap/Form';
import { useRouter } from 'next/navigation'; 
import React, { useState, useEffect } from 'react';
import { redirect } from 'next/navigation';

export default function SearchBar() {
   const [searchText, setSearchText] = useState<string>('');

   const inputHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
      setSearchText(e.target.value);
    };

   const router = useRouter(); 

   const handleKeyDown = (event : React.KeyboardEvent<HTMLInputElement>) => {
      if (event.key === 'Enter' && searchText.trim() !== '') {
         router.push(`/search/${encodeURIComponent(searchText)}`);
      }
   }

   //<Link href={'/search/'+ searchText} className="search_button">Search</Link>

  return (
     <div>
        <div className="search-bar">
            <input className="form-control search-bar" type="text" placeholder="Search groceries and save money" onChange={inputHandler} onKeyDown={handleKeyDown} />
        </div>
     </div>
  )
}


