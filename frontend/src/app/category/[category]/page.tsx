import React from 'react'
import SearchResultsPage from '../../../pages/SearchResultsPage/SearchResultsPage';


async function getProduct(category: String) {
  const res = await fetch('http://localhost:8080/api/v1/product/category/' + category)

  return res.json()
}


export default async function ProductDetails({ params }: { params: any }) {
  const arrProducts = await getProduct(params.category)

  return (
    <SearchResultsPage inputProducts={arrProducts} title={params.category} />
  )
}
