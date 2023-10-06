import Link from 'next/link';
import PriceComparison from '../../components/PriceComparison/PriceComparison';
import './ProductPage.css'


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
  inputProducts: Product[];
}

export default function ProductPage({ inputProducts }: ProductPageProps) {
  // Check if inputProducts is an array and contains at least one element
  if (!Array.isArray(inputProducts) || inputProducts.length === 0) {
    // Handle the case where inputProducts is empty or not an array
    return <div>No product data available.</div>;
  }
  return (
    <div className="product-page">
        <div>
            <div className="header_row">
              <Link href='/' >Back</Link>
              <h1>Product details</h1>
              <div></div>
            </div>
            <div className="pp_container">

              <div className="pp_container-product">

                <div className="pp_container-product_box">
                  <div className="pp_container-product_box-comparison">
                    <h2>{inputProducts[0].title}</h2>
                    <PriceComparison comparisonProducts={inputProducts} showAdd={true} />
                  </div>
                </div>

                <div className="pp_container-product_details">
                  <p>
                    {inputProducts[0].description}
                  </p>
                </div>

              </div>
            </div>

        </div>
    </div>
  )
}
