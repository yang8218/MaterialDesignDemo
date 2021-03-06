package com.yang.materialdesigndemo;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link BooksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BooksFragment extends Fragment implements OnRecyclerItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private FloatingActionButton fAB;
    private BookRecyclerAdapter adapter;
    private List<Book> books;


    public BooksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BooksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BooksFragment newInstance(String param1, String param2) {
        BooksFragment fragment = new BooksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_books, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        fAB = (FloatingActionButton) view.findViewById(R.id.fab);
        fAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new BookRecyclerAdapter(getActivity(),this);
        recyclerView.setAdapter(adapter);
        initDate();

        return view;

    }

    private void initDate(){
        books = new ArrayList<>();
        Book book1 = new Book();
        book1.setTitle(getString(R.string.book_title_1));
        book1.setAuthor(new String[]{"刘慈欣"});
        book1.setImageId(R.drawable.book1);
        book1.setSubtitle(" ");
        book1.setPubDate("2008-01-01");
        book1.setPages("302");
        book1.setPrice("23.00元");
        books.add(book1);

        Book book2 = new Book();
        book2.setTitle(getString(R.string.book_title_2));
        book2.setAuthor(new String[]{"刘慈欣"});
        book2.setImageId(R.drawable.book2);
        book2.setSubtitle("");
        book2.setPubDate("2008-05-01");
        book2.setPages("470");
        book2.setPrice("32.00元");
        books.add(book2);

        Book book3 = new Book();
        book3.setTitle(getString(R.string.book_title_3));
        book3.setAuthor(new String[]{"刘慈欣"});
        book3.setImageId(R.drawable.book3);
        book3.setSubtitle("");
        book3.setPubDate("2010-11-01");
        book3.setPages("513");
        book3.setPrice("38.00元");
        books.add(book3);

        adapter.setBookList(books);


    }


    @Override
    public void OnItemClick(int position) {

//        Snackbar.make(recyclerView,"点击"+books.get(position).getTitle(),Snackbar.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(),BookDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean OnItemLongClick(int position) {
        Snackbar.make(recyclerView,"长按"+books.get(position).getTitle(),Snackbar.LENGTH_SHORT).show();
        return true;
    }
}
