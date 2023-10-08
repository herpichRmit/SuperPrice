import React from 'react'
import ProductPage from '../../../pages/ProductPage/ProductPage';
export const dynamic = 'force-dynamic'

async function getProduct(title: String) {
  const res = await fetch(process.env.API_URL + '/api/v1/product/compare/' + title, { next: { revalidate: 0 } })
  
  if (!res.ok) {
    // This will activate the closest `error.js` Error Boundary
    throw new Error('Failed to fetch data')
  } else {
    return res.json()
  }
}


export default async function ProductDetails({ params } : { params: any }) {
  const arrProducts = await getProduct(params.title)

  return (
    <ProductPage inputProducts={arrProducts} />
  )
}
