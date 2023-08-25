import NavBar from '../../components/NavBar/NavBar.tsx';
import SearchBar from '../../components/SearchBar/SearchBar.tsx';
import CategoriesMenu from '../../components/CategoriesMenu/CategoriesMenu.tsx';

export default function HomePage() {
  return (
    <div className="home-page">
        <NavBar />
        <main>
            <SearchBar />
            <CategoriesMenu />
        </main>
    </div>
  )
}
