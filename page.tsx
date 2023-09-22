import React from 'react'
import TestPage from '../../pages/TestPage/TestPage';


async function getProduct(title: String) {
    const res = await fetch('http://localhost:8080/api/v1/product/price/' + title)

  return res.json()
}


export default async function ProductDetails({ params }: { params: String }) {     //({ params }: { params: any }) {
    const arrProducts = await getProduct("Milk")

return (
  <TestPage inputProducts={arrProducts} />
)
}
