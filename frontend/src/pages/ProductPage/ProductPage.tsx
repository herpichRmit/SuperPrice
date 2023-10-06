import Link from 'next/link';
import NavBar from '../../components/NavBar/NavBar';
import PriceComparison from '../../components/PriceComparison/PriceComparison';
import './ProductPage.css'

/*
<PriceComparison/>
<PriceComparison/>
<AlternateProductMenu/>
*/

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

  return (
    <div className="product-page">
        <main>
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



        </main>
    </div>
  )
}
