import React from 'react'
import SearchResultsPage from '../../../pages/SearchResultsPage/SearchResultsPage';

async function getProduct(title: String) {
  const res = await fetch('http://localhost:8080/api/v1/product/search/' + title)

  return res.json()
}


export default async function ProductDetails({ params } : { params: any }) {
  const arrProducts = await getProduct(params.title)

  return (
    <SearchResultsPage inputProducts={arrProducts} title={""} />
  )
}
