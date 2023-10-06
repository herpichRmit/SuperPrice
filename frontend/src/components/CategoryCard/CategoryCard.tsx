"use client"

import './CategoryCard.css'

//import { switchPage } from '../../app/page'
//import SearchResultsPage from '../../pages/cSearchResultsPage/SearchResultsPage'

import Form from 'react-bootstrap/Form';
import { useRouter } from 'next/navigation'; 
import React, { useState, useEffect } from 'react';
import { redirect } from 'next/navigation';

interface Price {
    store : String
    priceCents : number
}

interface Products {
    name: string;
    brand: string;
    size: string;
    prices: Price[];
}

interface CategoryProps {
    name : String,
    products : Products[]
}

interface CategoryCardProps {
    category : CategoryProps
}

export default function CategoryCard ({ category } : CategoryCardProps) {

   const router = useRouter(); 

    let handleClick = function (event : React.MouseEvent<HTMLElement>) {
        router.push(`/category/${category.name}`);
    }

    return (

        <div className="category-card" onClick={handleClick.bind(category)} >
            <div className="category-label">
                <h3>{category.name}</h3>
            </div>
        </div>

    )
}

