"use client"

import React from 'react'

import './CategoriesMenu.css'

import CategoryCard from '../../components/CategoryCard/CategoryCard'

export default function CategoriesMenu() {
  let [categories, setCategories] = React.useState ([]);
  let [isLoaded, setIsLoaded] = React.useState (false);

  let categoryCards = [];

  if (isLoaded) {
    categories.forEach (category => {
      categoryCards.push (<CategoryCard category={category} />)
    })
  } else {
    fetch ("http://localhost:8080/api/catalog/category")
      .then (response => {
        response.json ().then (json => {
          setCategories (json)
          setIsLoaded (true)
        })
      })
  }

  return (
    <div className="categories-menu">
      {categoryCards}
    </div>
  )
}

