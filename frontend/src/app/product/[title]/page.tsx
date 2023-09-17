import React from 'react'
import ProductPage from '../../../pages/ProductPage/ProductPage';

async function getProduct(title: String) {
    const res = await fetch('http://localhost:8080/api/v1/product/compare/' + title)
  
    return res.json()
  }

  //
  //<ProductPage />
export default async function ProductDetails({ params }: { params: any }) {
    const arrProducts = await getProduct(params.title)

  return (
    <ProductPage inputProducts={arrProducts} />
  )
}
