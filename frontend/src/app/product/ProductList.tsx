import React from 'react'

async function getProducts() {
  const res = await fetch('http://localhost:8080/api/v1/product')

  return res.json()
}

export default async function ProductList() {
  const tickets = await getProducts()

  return (
    <div>TicketList</div>
  )
}
