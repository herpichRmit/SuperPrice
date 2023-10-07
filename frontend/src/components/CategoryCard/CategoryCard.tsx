"use client"

import './CategoryCard.css'

//import { switchPage } from '../../app/page'
//import SearchResultsPage from '../../pages/cSearchResultsPage/SearchResultsPage'

import Form from 'react-bootstrap/Form';
import { useRouter } from 'next/navigation'; 
import React, { useState, useEffect } from 'react';
import { redirect } from 'next/navigation';

interface PriceProps {
    store : String
    priceCents : number
}

interface ProductProps {
    name: string;
    brand: string;
    size: string;
    prices: PriceProps[];
}


interface CategoryProps {
    name : String,
    products : ProductProps[]
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
                <h5>{category.name}</h5>
            </div>
        </div>

    )
}

