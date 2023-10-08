"use client"

import React from 'react'

import './CategoriesMenu.css'

import CategoryCard from '../../components/CategoryCard/CategoryCard'

export const dynamic = 'force-dynamic'


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

interface HomePageProps {
  inputCategories : CategoryProps[]
}


export default function CategoriesMenu({ inputCategories }: HomePageProps) {
  let [categories, setCategories] = React.useState<CategoryProps[]>([]);
  let [isLoaded, setIsLoaded] = React.useState (false);

  let categoryCards : any[] = [];


  if (isLoaded) {
    categories.forEach (category => {
      categoryCards.push (<CategoryCard category={category} />)
    })
  } else {
    
    if (inputCategories !== undefined) {
      setCategories(inputCategories)
      setIsLoaded (true)
  }
}

  return (
    <>
      <div className='categories-menu'>
        <h3>Browse by category</h3>
        <div className="categories-menu_row">
          {categoryCards}
        </div>
      </div>
    </>
  )

}