import React from 'react'
import ProductPage from '../../../pages/ProductPage/ProductPage';

async function getProduct(id: any) {
    const res = await fetch('http://localhost:8080/api/v1/product/' + id)
  
    return res.json()
  }

  //<ProductPage />
export default async function ProductDetails({ params }: { params: any }) {
    const product = await getProduct(params.id)

  return (
    <ProductPage inputProduct="" />
  )
}
