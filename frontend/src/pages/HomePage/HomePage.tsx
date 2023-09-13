import NavBar from '../../components/NavBar/NavBar';
import SearchBar from '../../components/SearchBar/SearchBar';
import CategoriesMenu from '../../components/CategoriesMenu/CategoriesMenu';
import Link from 'next/link'

export default function HomePage() {
  return (
    <div className="home-page">
        <NavBar shouldShowSearchBar={false}/>
        <main>
            <SearchBar />
            <CategoriesMenu />
            <Link href="/SignUp/signup">
              Go to SignUp
            </Link>
        </main>
    </div>
  )
}
