import React from 'react'
import './PriceComparison.css'


interface Product {
  id: number;
  title: string;
  store: string;
  brand: string;
  category: string;
  price: number;
  description: string;
}

interface ProductPageProps {
  comparisonProducts: Product[];
}

//<img src="" alt="" />

export default function PriceComparison({ comparisonProducts, showAdd }: ProductPageProps & { showAdd: Boolean }) {
  return (
    <div className="price-comparison">

      {comparisonProducts.map((product) => (
        <>
          <div className="pc_entry">
              <div className="img-box">
                <p>{product.store}</p>
              </div>
              <div className="pc_entry-priceandbutton">
                <p>${product.price}</p>
                {showAdd ? <button>Add to cart</button> : ""}
              </div>
          </div>
          <hr />
        </>
      ))}

    </div>
      
  )
}
